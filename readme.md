**Context:**

This document outlines my attempt to solve a coding challenge for **Hotmart**. Below is the full description of the challenge provided as part of the task.
For the challenge, I used **SpringBoot**.

## Version

1.2.1

## Context

Imagine you're a developer at a tech company, and your new task is to build part of a high-traffic product marketplace.

So far, you’ve received the description of the following entities:

* [x] Product: ID, name, description, creation date
* [x] Buyer: ID, name
* [x] Seller: ID, name
* [x] Product Category: ID, name
* [x] Sale: ID, seller, buyer, product

When a buyer purchases a product, they can rate it from 0 to 5 (this rating is not yet mapped in the entities).

One of the most important parts of the marketplace being built is the product search feature. Each product will receive a daily ranking score calculated using the following formula:

```
X = Average rating of the product over the last 12 months  
Y = Number of sales / days the product has existed  
Z = Number of news articles related to the product category on the current day
```

Score = X + Y + Z

## The Challenge

Your task is to:

* Create a CRUD (Create, Read, Update, Delete) for products.
* Build a Product API exposing the CRUD operations (list, find, delete, update, insert).
* Create a service to search for products ordered by ranking, filtered by name and category.

  * The service output must include the fields `currentDate` and `searchTerm`, along with the list of products matching the search. Each returned product must include: { `id`, `name`, `description`, `creationDate`, `score` }
* All services must be auditable.

## Notes:

* To get the number of news articles for a given category, you can use the API at [https://newsapi.org/](https://newsapi.org/). Model the entities accordingly to fit the scenario. Also, create initial data for these entities.
* You should query the [https://newsapi.org/docs/endpoints/top-headlines](https://newsapi.org/docs/endpoints/top-headlines) endpoint 4 times a day (feel free to choose the best strategy), store the data locally, and use the publication date of each article to support the required logic.

## What We Expect from Your Test

* We want to assess your technical skills, analytical thinking (preferably through short and clear commit messages), and how you present results.
* You don’t have to implement everything listed, but we want a clear sense of how you approach problem-solving.
* Feel free to include/modify/remove entities, attributes, technologies, jobs, or anything else necessary to better address the challenge.

## Specifically, in your project delivery, we would like to see:

* Documentation
* Appropriate use of libraries
* Code written with clear semantics – readability is just as important as performance, and they don’t have to conflict.
* Decoupling and a clear hierarchy between system components
* Automated testing

## Things That Would Impress Us

* Fault tolerance – make the service more robust when calling the external news API.
* Caching – research and implement a cache library to speed up searches.
* Support for pagination in product listings
* Project containerization – Docker
* Strategy to avoid over-consuming the news API
* Tests beyond unit tests (e.g., integration, end-to-end)
* Use of a versioning tool for data loading scripts
* Well-structured solution architecture, appropriate design patterns, and object-oriented design
* Securing endpoints that persist data (you may use in-memory user/password auth)
* All code written in English

## What We Don’t Want to See

* Evidence that you didn’t do the test yourself
* Missing the main objectives of the challenge
* Very unreadable code
* Lack of documentation or instructions on how to run your project

## Evaluation Criteria

* Completion of proposed objectives
* Code semantics, structure, readability, maintainability, scalability, and decision-making
* Project organization
* Solution architecture, appropriate use of design patterns and OOP
* Performance, resilience, and error handling
* API documentation
* Entity modeling

# Requirements

* Must use Java or Kotlin
* Do not use tools or databases with commercial licenses
* Each table must contain at least 100 records
