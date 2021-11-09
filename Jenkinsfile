pipeline {
	agent any

	options {
		buildDiscarder(logRotator(numToKeepStr:'15'))
	}

	tools { 
		maven 'Maven3.3'
	}
	
	triggers {
		cron('H 21 * * *') 
	}

	stages {
		stage('Checkout') {
			steps {
				dir('.m2/repository') { deleteDir() }
				checkout scm
			}
		}

		stage('Maven Build') {
			steps {
				configFileProvider([configFile(fileId: 'global_maven_nexus-intern', variable: 'GLOBAL_SETTINGS')]) {
					sh "mvn -gs ${GLOBAL_SETTINGS} --batch-mode --errors --fail-at-end --show-version -DinstallAtEnd=true -DdeployAtEnd=true -f releng/org.safe4i.usf.parent/pom.xml -Dmaven.repo.local=${workspace}/.m2/repository clean install"
				}
            }
		}
	}

	post {
            always { archiveArtifacts 'releng/org.safe4i.usf.updatesite/**' }
            success { notifyemail("SUCCESS") }     
            failure { notifyemail("FAILURE") } 
            unstable {notifyemail("UNSTABLE") }
    }

}

@NonCPS
notifyemail(jobStatus){
  def jobName = currentBuild.fullDisplayName
  emailext body: '''${SCRIPT, template="groovy-html.template"}''', mimeType: 'text/html', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject:"[Jenkins] ${jobName} ${jobStatus}"
}
