# 📦 PPG Recoverable Assets & Inventory Risk Management (RA & IRM)

## 📖 Overview

This project was developed as a case study for inventory risk management and recoverable asset analysis using a modern Azure-based Data Engineering architecture.

The objective was to design and implement a complete end-to-end data pipeline capable of transforming raw inventory data into meaningful business insights. The solution supports inventory monitoring, provision analysis, stock risk identification, and decision-making through interactive Power BI dashboards.

The project followed a Medallion Architecture approach consisting of Bronze, Silver, and Gold layers to ensure data quality, scalability, and maintainability.

---

## 🏗️ Architecture Overview

The solution was built using Microsoft Azure services across multiple layers:

### Bronze Layer
Raw data ingestion and storage.

### Silver Layer
Data cleansing, transformation, and business rule implementation.

### Gold Layer
Business-ready semantic views and analytical datasets.

### Reporting Layer
Interactive dashboards and KPI monitoring through Power BI.

---

## 🛠 Technologies Used

### Cloud Platform
- Microsoft Azure

### Azure Services
- Azure Data Factory
- Azure Data Lake Storage Gen2
- Azure Synapse Analytics
- Power BI

### Data Engineering Concepts
- ETL Pipeline
- Medallion Architecture
- Data Transformation
- Data Modelling
- Business Intelligence
- Cloud Data Engineering

---

## 📊 Key Features

### Recoverable Assets (RA) Analysis
Identifies inventory that can potentially be recovered or reused before becoming obsolete.

### Inventory Risk Management (IRM)
Analyzes inventory health and categorizes materials according to risk levels.

### Provision Calculation
Implements business rules to calculate inventory provisions for:

- Healthy Inventory
- Expired Inventory
- Magna Carta Dead Stock

### Inventory Monitoring

Provides visibility into:

- Stock Levels
- Reorder Risks
- Dead Stock
- Inventory Aging
- Provision Amounts

### Business Intelligence Dashboard

Interactive Power BI dashboards support:

- Inventory Health Monitoring
- Financial Provision Analysis
- Operational Decision Making
- Executive Reporting

---

## 📂 Project Deliverables

| Deliverable | Description |
|------------|-------------|
| Technical Report | Complete project documentation |
| Azure Pipeline | End-to-end data engineering workflow |
| Synapse SQL Views | Business-ready semantic layer |
| Power BI Dashboard | Inventory analytics and reporting |
| Data Architecture Design | Medallion Architecture implementation |

---

## 📚 Key Learning Outcomes

### End-to-End Data Pipeline Development

Learned how data flows from ingestion to reporting through multiple Azure services.

### Medallion Architecture

Gained practical experience implementing Bronze, Silver, and Gold layers for structured data management.

### Cloud Data Engineering

Developed hands-on experience using Azure services within a modern cloud environment.

### Business-Oriented Analytics

Learned how technical solutions support business requirements and operational decision-making.

### Data Visualization

Applied Power BI to transform processed data into actionable insights and interactive dashboards.

---

## 🌱 Reflection

The PPG Recoverable Assets and Inventory Risk Management project provided valuable experience in developing a complete end-to-end data engineering solution using Microsoft Azure. Unlike standalone tutorials, this project required integrating multiple Azure services into a unified workflow, beginning with data ingestion and ending with analytical reporting.

Through the implementation of Medallion Architecture, a deeper understanding was gained on how raw data progresses through Bronze, Silver, and Gold layers before becoming business-ready information. Practical exposure to Azure Data Factory, Azure Synapse Analytics, and Power BI also demonstrated how modern cloud technologies work together to support enterprise data solutions.

One of the most significant learning experiences was translating business requirements into technical implementations. Inventory concepts such as Recoverable Assets, Magna Carta Dead Stock, inventory provisions, and stockout risks were transformed into data processing logic and dashboard visualizations. This highlighted the importance of combining technical knowledge with business understanding in real-world data engineering projects.

Overall, the project strengthened knowledge of azure, data pipelines, ETL processes, semantic modelling, and business intelligence reporting while providing industry-relevant experience that closely reflects modern Data Engineer responsibilities.

---

## 🚀 Key Takeaway

> Modern Data Engineering is not only about processing data, but also about transforming business requirements into scalable and actionable data solutions that support decision-making.
