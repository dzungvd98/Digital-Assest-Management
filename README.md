# Digital-Assest-Management
Designing and implementing a permission management system for a directory and file structure across multiple drives

# Mind map for create digital assets management
![Digital Assets Management](https://github.com/user-attachments/assets/39a7126f-07fd-46cf-95f7-dc6b201427eb)

## Overview

This project implements a Digital Asset Management (DAM) system that allows users to manage files and folders across multiple drives. The system supports a permission management system where users can have multiple roles (Admin, Contributor, Reader) for each drive.

## Features

- **User Management**: Each user can own multiple drives, and each drive can contain multiple folders and files.
- **Permission Management**: Users can be assigned different roles (Admin, Contributor, Reader) for each drive. A user can have all three permissions simultaneously for a drive.
- **Folder and File Management**: Users with appropriate permissions can create, modify, and delete folders and files.
- **Access Control**: The system ensures that users can only perform actions they have permission for.

## Roles

- **Admin**: 
  - Can manage the entire system, including creating drives, folders, and files.
  - Can share permissions with other users for specific folders or files.
- **Contributor**: 
  - Can add, modify, and delete folders and files within their assigned scope.
- **Reader**: 
  - Has read-only access and cannot perform any modifications.

## Project Structure

The project consists of the following main components:

- **User**: Represents a user in the system. Each user can have multiple permissions on different drives.
- **Drive**: Represents a drive that can contain multiple root folders and files.
- **Folder**: Represents a folder that can contain subfolders and files. Permissions can be assigned to users for these folders.
- **DAMFile**: Represents a file within a folder.
- **Permissions**: An enum that defines the roles a user can have (Admin, Contributor, Reader).
- **DigitalAssetManagement**: The main class that manages users, drives, folders, and files.

