
This is a Kotlin Multiplatform project targeting Android, iOS.

Architecture
The project architecture is based on Clean Architecture, with a clear separation of concerns:

Five-Layer Architecture:
# Five-Layer Architecture

## Overview

The architecture is divided into five layers to ensure clarity, modularity, and scalability:

1. **App**
2. **View**
4. **Domain**
5. **Data**
5. **Remote**

---

## Layer Details

### 1. App
- **Purpose**: Contains all applications within the project as well.
- **Applications**:
  - Serve as entry points, focusing solely on initialization and wiring where possible.

---

### 2. View
- **Purpose**: Manages views and application entry points.
- **Components**:
  - **Compose Views**: The entry points for the app.
  - **If I got more Times**:
     - A Dedicated navigation module to managing navigation in a clean and isolated manner.
     - A Presentation module which would contains logic related to ViewModels and UiModels

---

### 3. Domain
- **Purpose**: Centralized core logic and rules of the application, split into three submodules for clarity:
  - **Models**:
    - Domain models with business logic and validation rules.
    - If a model has construction rules (e.g., defaults, filtering), these are encapsulated in a **Builder**.
    - Models typically have **internal constructors** to enforce rules.
    - For dependency reasons (e.g., avoiding cyclic dependencies), certain repositories used by builders are declared in this module.
  - **UseCases**:
    - Contains all business use cases.
  - **Repositories**:
    - Defines only the **interfaces** for repositories.
    - Ensures **dependency inversion** for use cases.

---

### 4. Data
- **Purpose**: Glue between domain and remote.

---

### 5. Remote
- **Purpose**: Handles interactions with external data sources and provide models.

### Key Technical Choices

Kotlin Multiplatform: Learn more.
JetBrains Compose: Used for building UIs.
Koin: For dependency injection
Ktor: For networking.

---

