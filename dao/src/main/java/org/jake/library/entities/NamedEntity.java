package org.jake.library.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Soumen Karmakar
 * 05/05/2020
 */
@MappedSuperclass
@Data
public class NamedEntity extends BaseEntity {
    private String name;
}
