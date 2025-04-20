node {
    def mvnHome
    stage('Get Latest Changes') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/DoaaHamdy12/Final_Project.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'MAVEN_HOME'
    }
    stage('clean old builds') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean test'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean test/)
            }
        }
    }
    stage('run tests') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean test -X'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean test -X/)
            }
        }
    }
    stage('Results') {
      allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'allure-results']]
    }
}
