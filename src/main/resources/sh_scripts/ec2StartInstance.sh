#!/bin/bash
aws ec2 start-instances --instance-ids $1 --output json