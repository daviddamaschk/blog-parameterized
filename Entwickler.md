# Jenkins Pipeline


### Konfiguration


1. Maven konfigurieren als Globale Variable

    Unter Manage Jenkins -> Global Tool Configurator sollte Maven hinzugefügt werden.
    Der Name dieser Installation (z.b. M3) kann dann im Pipelinescript unter tools als zu verwendende Maven-Version angegeben werden.

2. Benötigte Jenkins-Plugins

    - Pipeline
    - Pipeline Utility Steps (um Befehle wie readJson ausführen zu können)
    - Groovy Postbuild (Für manager.addShortText)

3. Globale Groovy-Bibliotheken

    Um Groovy-Bibliotheken verwenden zu können, müssen diese unter Manage Jenkins -> Configure System -> Global Pipeline Libraries hinzugefügt werden. Hierbei muss das Repository angegeben werden, in dem diese liegen. Der Name dieser Bibliothek muss anschließend im Jenkinsfile unter @Library('name') angegeben werden.

4. Credentials eintragen

    Credentials für den Zugriff auf Git können unter Credentials eingetragen werden.
    Zusätzlich auch Gitlab-Api-Tokens.


5. Pipeline-Job anlegen

    Das Projekt muss parametrisiert sein und ein String Parameter "gitProjectUrl" mit der Url zum Projekt angegeben werden. Dieses wird intern noch einmal ausgecheckt, bevor der Build-Prozess durchläuft.

    Unter Pipeline soll das Skript aus einem anderem Repository stammen. Dieses muss hier angegeben werden. Soll nur der Master gebaut werden, kann */master eingetragen werden, ansonsten */* für alle Branches.

6. Idea Autocompletion für Jenkins Pipeline

    Siehe auch https://st-g.de/2016/08/jenkins-pipeline-autocompletion-in-intellij
    Um diese in JenkinsFiles zu nutzen, muss unter Idea-Settings in File Types unter Groovy das Pattern Jenkinsfile* hinzugefügt werden.
