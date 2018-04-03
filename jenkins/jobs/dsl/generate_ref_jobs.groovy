// Folders
def workspaceFolderName = "${WORKSPACE_NAME}"
def projectFolderName = "${PROJECT_NAME}"

// Jobs reference
def generateJavaReferenceAppJobs = freeStyleJob(projectFolderName + "/Generate_Reference_App_Jobs")

generateJavaReferenceAppJobs.with{
  parameters{
    stringParam("GIT_REPOSITORY","ref-src-android-app","Repository name to build the project from.")
	stringParam("API_KEY","","Repository name to build the project from.")
	stringParam("JIRA_LINK","","Repository name to build the project from.")
	stringParam("JENKINS_SLAVE","android-slave","Jenkins slave label with installed Android sdk.")
	stringParam("TOKEN","","TOKEN to remote trigger jobs")
	stringParam("JIRA_USER","","User name with enabled REST API")
	stringParam("JIRA_USER_PW","","Password for given user")
  }
  environmentVariables {
      env('WORKSPACE_NAME',workspaceFolderName)
      env('PROJECT_NAME',projectFolderName)
  }
  wrappers {
    preBuildCleanup()
    injectPasswords()
    maskPasswords()
  }
  steps {
      shell ('''set +x
            |set +e
            |git ls-remote ssh://gerrit:29418/${PROJECT_NAME}/${GIT_REPOSITORY} 2> /dev/null
            |ret=$?
            |set -e
            |if [ ${ret} != 0 ]; then
            | echo "Creating gerrit project : ${PROJECT_NAME}/${GIT_REPOSITORY} "
            | ssh -p 29418 gerrit.service.adop.consul gerrit create-project ${PROJECT_NAME}/${GIT_REPOSITORY} --empty-commit
            |else
            | echo "Repository ${PROJECT_NAME}/${GIT_REPOSITORY} exists! Creating jobs..."
            |fi'''.stripMargin())
      dsl {
        text(readFileFromWorkspace('cartridge/jenkins/jobs/dsl/android_deployent.template'))
      }
  }
}
