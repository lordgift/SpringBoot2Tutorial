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
        sh 'mvn cobertura:cobertura'
        cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', failUnhealthy: false, failUnstable: false
      }
    }
    stage('SonarQube analysis') {
      steps {
        sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
      }
    }
    stage('Postman API Testing') {
      steps {
        sh 'newman run Testing.postman_collection.json'
      }
    }
  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
    }
  }
}
