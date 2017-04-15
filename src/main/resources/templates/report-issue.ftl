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
            <form class="form-horizontal" role="form" name="issue" action="reportIssue" method="post" id="issue">
                <h3>Report Issue</h3>
                <div class="form-group">
                    <label for="title" class="col-sm-3 control-label">Title</label>
                    <div class="col-sm-9">
                        <input type="text" id="title" placeholder="Title" class="form-control" autofocus>
                       <!-- <span class="help-block">Last Name, First Name, eg.: Smith, Harry</span> -->
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label">Description</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" rows="5" id="description"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="categoryId" class="col-sm-3 control-label">Category</label>
                    <div class="col-sm-9">
                        <select name="categoryId">
                        	<#if categories?has_content>
                        		<#list categories as category>
                        			<option name=${category.name} value="${category.value?c}"> ${category.name} </option>
                        		</#list>
                        	</#if>
						</select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="hashtags" class="col-sm-3 control-label">Hashtags</label>
                    <div class="col-sm-9">
                        <input type="text" id="hashtags" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="contactName" class="col-sm-3 control-label">Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="contactName" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="contactMobile" class="col-sm-3 control-label">Contact Information</label>
                    <div class="col-sm-9">
                        <input type="text" id="contactMobile" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Report</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
</body>
</html>  