<html>
<head>
<#import "spring.ftl" as spring />
<title>Source First</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" 
    href="./css/main.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<body>

<div id="header">
<h1 align="center">
	Source First
</h1>
</div>

<div class="container">
            <table class="table table-striped table-hover" role="table">
			  <thead>
			    <tr>
			      <th>Title</th>
			      <th>Hashtags</th>
			      <th>Anonymous</th>
			      <th>Name</th>
			      <th>Contact</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<#if reports?has_content>
            		<#list reports as report>
            			<tr>
					      <td>${report.title}</td>
					      <td>${report.hashtags}</td>
					      <td>${report.isAnonymous()?string}</td>
					      <td></td>
					      <td></td>
					    </tr>
            		</#list>
            	</#if>
			  </tbody>
			</table>
        </div> <!-- ./container -->

</body>
</html>  