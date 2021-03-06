package com.example.demo.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhaoyiwei 2018/5/21 15:41
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "int(16) COMMENT '主键'")
    protected Long  id;
    @CreatedDate
    private Date createdTime;
    @LastModifiedDate
    private Date modifiedTime;
    @Transient
    private Integer pageNo;

    public void setPageNo(Integer pageNo) {
        if (pageNo != null)
            this.pageNo = pageNo - 1 < 0 ? 0 : pageNo - 1;
    }
}
