/**
 * 
 */
package com.walmart.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.walmart.app.model.OrderInfo;

/**
 * @author raidentrance
 *
 */
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderInfoRepository extends PagingAndSortingRepository<OrderInfo, String> {

}
