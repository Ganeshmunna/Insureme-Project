node {
	    def mavenHome
	    def mavenCMD
	    def docker
	    def dockerCMD
	    def tagName
	    
	    stage('initialization'){
	        echo 'initialize the variables'
	        mavenHome = tool name: 'myMaven' , type: 'maven'
	        mavenCMD = "${mavenHome}/bin/mvn"
	        docker = tool name: 'myDocker' , type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
	        dockerCMD = "${docker}/bin/docker"
	        
	    }
	    stage('git code checkout'){
	        
	        echo 'code checkout'
	        git ' https://github.com/swapnilsjadhav9519/insurance.git'
	        	
	    }
	    stage('maven build'){
	        echo ' clean and compile and test package'
	        //sh 'mvn clean package'
	        sh "${mavenCMD} clean package"
	    }
	    
	    
	    stage ('containerize the application')
        {	        
	        echo 'build the docker image'
	        sh "${dockerCMD} build -t swapnil9519/insurance:1.0 ."	        
	    }
	    stage ('push docker image to dockerhub')
	    echo 'pushing the docker image to DockerHub'
	    
	    withCredentials([string(credentialsId: 'dockpassid', variable: 'dockpass')]) 
	    {
	       sh "${dockerCMD} login -u swapnil9519 -p ${dockpass}"
	       sh "${dockerCMD} push swapnil9519/insurance:1.0"
	    }
	    stage ('Configure and Deploy to the test-server'){
	        ansiblePlaybook become: true, disableHostKeyChecking: true, installation: 'myAnsible', inventory: '/etc/ansible/hosts', playbook: 'ansible-playbook.yml'
	    }
	    
	}
