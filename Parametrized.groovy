pipeline {
  agent any

  parameters {
    file(
      description: 'This is parameterized build',
      name: 'property1.txt'
    )
  }

  stages {
    stage("Wat") {
      steps {
        echo "Some output"
      }
    }
  }
}