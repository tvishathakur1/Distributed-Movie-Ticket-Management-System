# Distributed Movie Show Management System

This project is a **Distributed Movie Ticket Booking System** that I developed to manage movie tickets across multiple theaters using web services. The system includes both admin and customer functionalities, providing a robust solution for booking and managing movie tickets.

## Table of Contents
- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Features](#features)
- [Recovery](#recovery)

## Overview

The system manages movie tickets across theaters and each theater streams different movies.

Users interact with the system in two roles:
- **Admin**: Can add/remove movie slots, and list available shows.
- **Customer**: Can book/cancel tickets and view booking schedules.

## Technologies Used

- **Java** for implementing the server-client communication.
- **Web Services** for the communication between components.
- **UDP Multicast** for distributing requests reliably across replicas.

## Architecture

The architecture is designed to ensure high availability and fault tolerance through the following components:

- **Client**: Sends requests via HTTP to the front-end.
- **Front-End**: Mediates between clients and the sequencer, detects failures, and returns responses.
- **Sequencer**: Assigns sequence numbers to requests and sends them to replicas.
- **Replica**: Processes requests and returns results to the replica manager.
- **Replica Manager**: Manages replica fault tolerance and recovery in case of errors or crashes.

### System Diagram

## Features

1. **Total Ordering**: Ensures that all requests are processed in the same order across replicas.
2. **Reliable Multicast**: Uses UDP multicast to efficiently deliver requests to all replicas.
3. **Failure Tolerance**: Automatically handles both software and crash failures.
4. **Data Consistency**: Ensures all replicas maintain consistent states.
5. **Dynamic Timeout**: Adjusts timeouts based on server performance for better fault detection.

<img src="https://github.com/user-attachments/assets/4d52060b-807d-4b17-8579-4b5355c7c648" alt="Architecture Design" style="width: 500; height: 300;">


## Recovery

### Software Recovery
If a replica gives three incorrect responses, it will be replaced by a backup replica, ensuring uninterrupted service.

### Crash Recovery
In case of a crash, the system automatically restarts the crashed replica using a shell script, ensuring continued operation.

