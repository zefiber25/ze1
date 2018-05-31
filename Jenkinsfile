pipeline {
    agent none
    environment {
      ORG               = 'zefiber25'
      APP_NAME          = 'ze1'
    }
    stages {
	      stage('Maven Install') {
			  agent {
				docker {
				  image 'maven:3.5.0'
				}
			  }
			  steps {
				sh 'mvn clean install'
			  }
		  }
		  stage('Docker Build') {
			  agent any
			  steps {
				sh 'docker build -t zefiber/ze1:latest .'
			  }
		  }
      }
      
  }
