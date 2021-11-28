pipeline
{
  agent any
//   This is the demo for how to list jenkins env variable or set env variable.
  environment
  {
    FIRST_NAME = "Krunal"
  }
  stages
    {
        stage("Jenkins Env Variable List")
        {
            steps
            {
                sh "printenv | sort"
                sh "echo BUILD_NUMBER = $BUILD_NUMBER"
                echo "FIRST NAME = ${env.FIRST_NAME}"
            }
        }
    }
}