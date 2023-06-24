node {
    def mavenHome
    def mavenCMD
    def docker
    def dockerCMD
    def tagName
    
    stage('prepare environment'){
	        echo 'initialize the variables'
	        mavenHome = tool name: 'myMaven' , type: 'maven'
	        mavenCMD = "${mavenHome}/bin/mvn"
	        docker = tool name: 'myDocker' , type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
	        dockerCMD = "${docker}/bin/docker"
	        
	    }
	     stage('git code checkout'){
	        
	        echo 'code checkout'
	        git ' https://github.com/Ganeshmunna/Insureme-Project.git'
	        	
	    }
	    stage('maven build'){
	        echo ' clean and compile and test package'
	        //sh 'mvn clean package'
	        sh "${mavenCMD} clean package"
	    }
	    stage('publish html report'){
	        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '/var/lib/jenkins/workspace/Devproject/target/surefire-reports', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
	    }
	    stage ('containerize the application')
        {	        
	        echo 'build the docker image'
	        sh "${dockerCMD} build -t ganeshmunna/insurance:1.0 ."	        
	    }
	    stage ('push docker image to dockerhub')
	    echo 'pushing the docker image to DockerHub'
	    
	    withCredentials([string(credentialsId: 'docker-password', variable: 'DockerPassword')])
        {
        
         sh "${dockerCMD} login -u ganeshmunna -p ${DockerPassword}"
	     sh "${dockerCMD} push ganeshmunna/insurance:1.0"
	    }
	    stage ('Configure and Deploy to the test-server'){
	        ansiblePlaybook become: true, credentialsId: 'ansiblekey', disableHostKeyChecking: true, installation: 'MyAnsible', inventory: '/etc/ansible/hosts', playbook: 'ansible-playbook.yml'
	    }
	    
	    
	}
