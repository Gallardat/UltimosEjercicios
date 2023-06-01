package com.softtek.proyecto2305.repositorio;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CrudImpl2<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

}
