#!/usr/bin/env bash

echo "Hello, $GITLAB_USER_LOGIN!"
git config --global user.name "kuldeep.yadav" && git config --global user.email "kuldeep.yadav@phonepe.com"
git remote set-url origin "git@gitlab.phonepe.com:${CI_PROJECT_PATH}.git"
git fetch
git checkout searchAndWatchlist && git reset --hard origin/searchAndWatchlist && git pull