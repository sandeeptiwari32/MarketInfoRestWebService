# MarketInfoRestWebService
extract market info using web crawling and transfer data into xml/json format using marketinfo rest web service

Above project is packed with all the dependent jar files.To deploy project follow below setps.

1. Download project from git.
2. to run project you can use below 2 steps.
    <br />a. import project in eclipse and run using eclipse's internal server.
    <br />b. put project into your web server(apache tomcat).
3. below is example Rest URL.
  <br />a. http://localhost:8080/MarketInfo/rest/stockinfo/<%Criteria%>/<%MarketType%> to get top 100 indian market companies.
  <br />b. http://localhost:8080/MarketInfo/rest/stockinfo/<%Criteria%>/<%MarketType%>/<%Sector%> to get top 100 indian market companies.

#for value of <%Criteria%>, <%MarketType%>, <%Sector%> look info.txt file 
