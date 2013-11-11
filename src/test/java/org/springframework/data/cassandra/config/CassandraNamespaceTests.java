package org.springframework.data.cassandra.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.cassandra.core.Keyspace;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.datastax.driver.core.Cluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CassandraNamespaceTests {

	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void testSingleton() throws Exception {
		Object cluster = ctx.getBean("cassandra-cluster");
		Assert.notNull(cluster);
		Assert.isInstanceOf(Cluster.class, cluster);
		Object ks = ctx.getBean("cassandra-keyspace");
		Assert.notNull(ks);
		Assert.isInstanceOf(Keyspace.class, ks);

		
		Cluster c = (Cluster) cluster;
		System.out.println(org.apache.commons.beanutils.BeanUtils.describe(c.getConfiguration()));
	}
	
}
