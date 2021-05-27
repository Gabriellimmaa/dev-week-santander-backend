package com.project.bootcamp.service;

import com.project.bootcamp.exceptions.BusinessException;
import com.project.bootcamp.exceptions.NotFoundException;
import com.project.bootcamp.mapper.StockMapper;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.repository.StockRepository;
import com.project.bootcamp.util.MessageUtils;
import org.apache.tomcat.jni.Local;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Liga o controller ao repositorio
@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional //É aqui que vai abrir a transação fazer o insert e fechar transação com banco de dados
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate()); //Criando um select no bando de dados automatico pesquisando por nome e data
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS); //Exibe a mensagem que esta em MessageUtils quando ocorrer essa condição
        }

        Stock stock = mapper.toEntity(dto); //transformeu em entidade
        repository.save(stock); //salvei no banco de dados
        return mapper.toDto(stock); //converti novamente para dto para passar ao controller passar para o front
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId()); //Criando um select no bando de dados manual pesquisando por nome e data
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS); //Exibe a mensagem que esta em MessageUtils quando ocorrer essa condição
        }

        Stock stock = mapper.toEntity(dto); //transformeu em entidade
        repository.save(stock); //salvei no banco de dados
        return mapper.toDto(stock); //converti novamente para dto para passar ao controller passar para o front
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id); //Utiliza a funcao de find by id
        repository.deleteById(dto.getId()); //Funcao deletando o ID
        return dto;
    }

    @Transactional()
    public List<StockDTO> findAll() {
        List<Stock> list = repository.findAll();
        return mapper.toDto(list);
    }

    @Transactional()
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new); //tenta enviar as informacoes, nao deu certo (orElseThrow) exibe a mensagem
    }

    @Transactional()
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }
}
