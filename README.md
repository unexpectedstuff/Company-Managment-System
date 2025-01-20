# Company-Managment-System
Employee and Client Management System

This is a simple Java program to simulate a simple company structure using OOP principles. The system manages employees (managers and workers) and clients. It included features for tracking employee working hours, vacation days, and sick days, and managing client spending over time. Also I created methods to generate data - since this is a class assignment.

## Features

- **Unique IDs for everyone**: Clients get IDs like C-001, and workers get IDs like W-001.
- **Track Spending**: Clients can log their spending for the last 30 days.
- **Track Hours**: Workers log their hours worked for the last 30 days.
- **Managers and Teams**: Managers can add workers to their team and see how many people are on it.
- **Vacation Days**: Managers get extra vacation days when their days are reset.

## Classes

- **Person**: The base class for both clients and workers, keeps their name and unique ID.
- **Client**: A type of Person that tracks daily spending for the last 30 days.
- **Worker**: Another type of Person that tracks hours worked for the last 30 days.
- **Manager**: A special worker who manages a team of workers and gets extra vacation days.
- **RegularWorker**: Just a regular worker with no team to manage.
- **Main**: The main class that starts the program and lets you interact with everything.

## Functions

- **generateData**: Adds some random data for clients and workers.
- **findWorkerByName**: Finds a worker by their name.
- **findClientByName**: Finds a client by their name.
- **findManagerByName**: Finds a manager by their name.

## How to Use

- **View Data**: See the current data for clients and workers.
- **Log Hours**: Add working hours for a worker on a specific day.
- **Update Spending**: Update a client's spending for a specific day.
- **Manage Teams**: Add or remove workers from a manager's team.

## Output example
```
    View Data
    Log Hours
    Update Spending
    Manage Teams
    Exit

Choose an option: 1

--- Clients --- Client ID: C-001 Name: Client 1 Spending: [random values]

--- Workers --- Worker ID: W-001 Name: Worker 1 Hours worked: [random values] Team Size: 2
```
