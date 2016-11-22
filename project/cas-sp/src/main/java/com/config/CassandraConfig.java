package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Created by arabbani on 11/19/16.
 */
@Configuration
@ConfigurationProperties(prefix = "cassandra", ignoreUnknownFields = false)
@EnableCassandraRepositories(basePackages = {"com.azracas.repo"})
/**
 * configuration properties defined under the prefix will be loaded in the matching name properties
 */
public class CassandraConfig {

    private static Logger log = LoggerFactory.getLogger(CassandraConfig.class);
    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(getContactpoints());
        cluster.setPort(Integer.parseInt(getPort()));
        return cluster;
    }
    @Bean
    public CassandraMappingContext mappingContext() {
        return new BasicCassandraMappingContext();
    }
    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }
    @Bean
    public CassandraSessionFactoryBean session() throws Exception {
        log.info("contactPoints="+contactpoints+", port="+port+", keyspace="+keySpace);
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(cluster().getObject());
        session.setKeyspaceName(getKeySpace());
        session.setConverter(converter());
        session.setSchemaAction(SchemaAction.NONE);
        return session;
    }
    @Bean
    public CassandraOperations cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }
    public String getContactpoints() {
        return contactpoints;
    }

    public void setContactpoints(String contactpoints) {
        this.contactpoints = contactpoints;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getKeySpace() {
        return keySpace;
    }

    public void setKeySpace(String keySpace) {
        this.keySpace = keySpace;
    }

    private String contactpoints;
    private String port;
    private String keySpace;
}
