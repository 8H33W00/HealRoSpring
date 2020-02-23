REPOSITORY= /workspace/HealRo/graduateProject # TODO 경로 수정
cd $REPOSITORY

echo "> 프로젝트 Build 시작"
./gradlew build
echo "> Build 파일 복사"
cp ./build/libs/*.jar $REPOSITORY/
echo "> 현재 구동중인 애플리케이션 pid 확인"
CURRENT_PID=$(pgrep -f graduateProject) # TODO 피드명 수정
echo "$CURRENT_PID"
if [ -z $CURRENT_PID ]; then

                echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
        else
                        echo "> kill -2 $CURRENT_PID"
                                kill -9 $CURRENT_PID
                                        sleep 5
                                fi
                                echo "> 새 어플리케이션 배포"
                                JAR_NAME=$(ls $REPOSITORY/ |grep 'graduateProject-0.0.1-SNAPSHOT.jar' | tail -n 1)
                                echo "> JAR Name: $JAR_NAME"
                                nohup java -jar $REPOSITORY/$JAR_NAME &
                                
