package com.tp.domain.book;

import jakarta.persistence.GenerationType;
import lombok.Data;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
 
@Data
@Entity
@Table(name = "BOOK")
public class Book {
 
	@Id
	private UUID id;
	private String title;
	private String author;
	private String isbn;
}
