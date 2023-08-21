package com.bebwhepan.app.Data;

//import java.util.Optional;
import com.bebwhepan.app.Models.Taco.TacoOrder;

// public interface OrderRepository {
//     TacoOrder save(TacoOrder order); //for 3.1 chapter 3

// }

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}