package com.nelioalves.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContainingIgnoreCase(String text); // query para o mongo
	
	@Query("{ 'title': { $regex: ?0, $options: 'i'} }") // a mesma de cima porém com regex
	List<Post> searchTitle(String text);

}
