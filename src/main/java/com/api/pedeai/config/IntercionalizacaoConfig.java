package com.api.pedeai.config;

import com.api.pedeai.rest.ApiErrors;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class IntercionalizacaoConfig {

    /*
     * Basename -> Busca o diretório do arquivo onde se encontra as mensagens
     * Default Encoding -> Padrão de palavras que estamos utilizando (acento, cedilhas, etc)
     * Default Locale -> Pega o local da máquina do usuário onde está sendo executado o programa
     */
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:message");
        source.setDefaultEncoding("ISO-8859-1");
        source.setDefaultLocale(Locale.getDefault());
        return source;
    }

    public LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
