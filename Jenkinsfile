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
				sh 'mvn clean install -Drevision=0.0.${BUILD_NUMBER}'
			  }
		  }
		  stage('Docker Build') {
			  agent any
			  steps {
				sh 'docker build -t zefiber/ze1:0.0.${BUILD_NUMBER} .'
			  }
		  }
		  stage('Docker Push') {
			  agent any
			  steps {
				withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
				  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
				  sh 'docker push zefiber/ze1:0.0.${BUILD_NUMBER}'
				}
			  }
          }
		  stage('K8s Deploy') {
		      steps {
				sh "kubectl --namespace=jx delete deployment ze1-deployment"
				sh "kubectl --namespace=jx delete service ze1-service"
				sh "kubectl --namespace=jx create -f ze1-deployment.yaml"
				sh "kubectl --namespace=jx set image deployment/ze1-deployment ze1=zefiber/ze1:0.0.${BUILD_NUMBER}"
			  }
          }
		  
  }
  
}
