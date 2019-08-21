package com.hfx.hfx_es.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hfx.hfx_es.Goods;

/**
 * 
 * @ClassName: GoodsTest
 * @Description: TODO
 * @author:HeFuXiang
 * @date: 2019年8月20日 上午8:23:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class GoodsTest {
    @Resource
	private ElasticsearchTemplate elasticsearchTemplate;
	@Test
	public void saveGoods() {
		//创建查询
		 IndexQuery query = new IndexQuery();
		 for(int i=1;i<5;i++) {
			 Goods goods = new Goods(i, "电脑", 3000.0);
			 query.setId(i+"");
			 query.setObject(goods);
			 elasticsearchTemplate.index(query);
		 }
		
	}
	@Test
	public void delGoods() {
		
		elasticsearchTemplate.delete(Goods.class, 1+"");
	}
	@Test
	public void selectGoods(){
		GetQuery query = new GetQuery();
		query.setId(2+"");
		Goods goods = elasticsearchTemplate.queryForObject(query, Goods.class);
		System.out.println(goods);
	}
	public void selectgoods() {
		
	}
}
