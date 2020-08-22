build_app:
	mvn package -DskipTests=true
run:
	make build_app && docker build . -t ebs_eureka_service && docker run --name ebs_eureka_server -p 8080:8080 --net=ebs_app_net --net-alias=ebseurekaserver -d -t ebs_eureka_server
stop:
	docker stop ebs_eureka_server