package org.lab3.wed.weblab3.DB.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "results", schema = "s338963")
public class Results {
    @Id
    private int id;
    private double x;
    private double y;
    private double z;
    private boolean hit;
    private LocalDateTime date;
    @Column(name = "exec_time")
    private long execTime;
}
