package com.bebwhepan.app.Data;

import com.bebwhepan.app.Models.Taco.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> { }