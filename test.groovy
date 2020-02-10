#!/bin/env groovy

node {
    checkout scm

    println "Get first property!!!"
    def props1 = new Properties()
    def stream = new FileInputStream("/usr/share/jenkins/ref/property1.txt")
    try {
    props1.load(stream)
    } finally {
    stream.close()
    }
    def var1 = Arrays.asList(props1)
    System.out.println(var1)
    return var1

    println "Get second property!!!"
    def props2 = new Properties()
    def stream2 = new FileInputStream("/usr/share/jenkins/ref/property2.txt")
    try {
    props2.load(stream2)
    } finally {
    stream2.close()
    }
    def var2 = Arrays.asList(props2)
    System.out.println(var2)
    return var2


properties([buildDiscarder(logRotator(numToKeepStr: '100')),
    parameters([
        [$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', description: 'filename', filterLength: 1, filterable: false, name: 'files', 
        script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''], 
        script: [classpath: [], sandbox: false,
        script: sh(returnStdout:true, script: 'cat /usr/share/jenkins/ref/property1.txt')]]], 
        [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT', description: '', filterLength: 1, filterable: false, name: 'value', randomName: 'choice-parameter-941595264446171', referencedParameters: 'files', 
        script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''], 
        script: [classpath: [], sandbox: false, script: sh(returnStdout:true, script: 'cat /usr/share/jenkins/ref/property2.txt')]]]])])

}
