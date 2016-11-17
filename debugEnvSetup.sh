docker run -d -p 4444:4444 --name selenium-hub selenium/hub
docker run -d -P -e no_proxy=localhost -e HUB_ENV_no_proxy=localhost -p 4445:4444 --link selenium-hub:hub selenium/node-chrome-debug
docker run -d -P -e no_proxy=localhost -e HUB_ENV_no_proxy=localhost -p 4446:4444 --link selenium-hub:hub selenium/node-firefox-debug