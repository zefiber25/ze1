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
		  stage('Docker Push') {
			  agent any
			  steps {
				withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
				  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
				  sh 'docker push zefiber/ze1:latest'
				}
			  }
          }
  }
