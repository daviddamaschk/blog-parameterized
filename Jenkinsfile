#!/usr/bin/env groovy
@Library('jenkins-pipeline-lib')
import de.mpc.pipeline.PropertyLoader

//noinspection GroovyAssignabilityCheck
pipeline {
    agent any

    tools {
        maven 'M3'
    }

    stages {
        stage('Checkout and load Parameters') {
            steps {
                git url: '${gitProjectUrl}',
                        credentialsId: 'XXXX-XXXX-XXXX'

                sh 'mvn clean install'

                script {
                    propertyLoader = new PropertyLoader(this)
                    propertyLoader.init()
                }
            }
        }

        stage('Tests') {
            when {
                expression {
                    return propertyLoader.runUnitTests()
                }
            }

            steps {
                sh 'mvn test'
            }
        }

    }

    post {
        always {
            deleteDir()
        }
        failure {
            step([$class                  : 'Mailer',
                  notifyEveryUnstableBuild: true,
                  recipients              : "${propertyLoader.getMailRecipients()}",
                  sendToIndividuals       : true])
        }
    }

}