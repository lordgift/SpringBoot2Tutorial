pipeline {
     agent any
     stages {
       stage('Pullcode') {
         steps {
             git 'https://github.com/lordgift/SpringBoot2Tutorial.git'
         }
       }
       stage('Testing') {
          steps {
            sh "mvn clean test"
            junit 'target/surefire-reports/*.xml'
          }
        }
        stage('Code coverage') {
          steps {
             cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', failUnhealthy: false, failUnstable: false
          }
        }
        stage('SonarQube analysis') {
            withSonarQubeEnv('My SonarQube Server') {
              sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
            }
        }
      }
      post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
      }
}
