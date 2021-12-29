Feature:  Service creation feature

Scenario:  Creates a new service in BestBuyAPIs
Given Create service payload
When User calls API with POST request
Then API call is successful with status code 201
And "name" in response body is "asian food court"