<%-- 
    Document   : meterReadingList
    Created on : May 20, 2015, 6:38:18 PM
    Author     : Bert
--%>
<%@ include file="../fragments/postAuth/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="${STATIC_URL}img/cws.ico">
        <title>Readings</title>
        <link href="${STATIC_URL}css/bootstrap.min.css" rel="stylesheet">
        <link href="${STATIC_URL}css/bootstrap-toggle.min.css" rel="stylesheet">
        <link href="${STATIC_URL}css/bootstrap-dialog.min.css" rel="stylesheet">
        <link href="${STATIC_URL}css/admin.css" rel="stylesheet">
        <link href="${STATIC_URL}css/font-awesome.min.css" rel="stylesheet">
        <sec:csrfMetaTags/>
    </head>
    <body>
        <jsp:include page="../fragments/postAuth/header.jsp"/>
        <div id="content-loader" class="loader"></div>
        <div id="main-content" style="display: none;" class="container">
            <div class="row">
                <div class="col-sm-8">
                    <h2>Meter Reading</h2>
                </div>
                <div class="col-sm-4 vertical-center text-right">
                    <button type="button" id="acc-tbr" class="btn btn-default">Accounts To Be Read</button>
                    <a type="button" class="btn btn-ctm btn-default"  href="${pageContext.servletContext.contextPath}/admin/reading/new/">Create Reading</a>
                </div>
            </div>
            <div id="search-filters" class="alert alert-info form-wrapper">
                <div id="reading-id" style="display:none"></div>
                <div class="col-sm-12">
                    <div class="col-md-3" id="acct-no">
                        <label>Account Number</label>
                    </div>
                    <div class="col-md-3" id="acct-lastname">
                        <label>Lastname</label>
                    </div>
                    <div class="col-md-3" id="acct-firstname">
                        <label>Firstname</label>
                    </div>
                    <div class="col-md-3" id="acct-brgy">
                        <label>Barangay</label>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="col-md-3" id="acct-zone">
                        <label>Purok</label>
                    </div>
                    <div class="col-md-3" id="reading-month">
                        <label>Reading Month</label>
                    </div>
                    <div class="col-md-3" id="reading-year">
                        <label>Reading Year</label>
                    </div>
                    <div class="col-md-3" id="inv-st">
                        <label>Status</label>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="pull-align-right col-md-3 vertical-center filter-btn-wrapper">
                        <a id="filterClearButton" type="button" class="btn btn-danger list-filter-btn"><i class="fa fa-remove fa-fw"></i> Reset </a>
                        <a id="filterButton" type="button" class="btn btn-primary list-filter-btn"><i class="fa fa-search fa-fw"></i> Search </a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 main">
                    <div class="table-responsive table">
                        <a id="mrListReload"></a>
                        <datatables:table deferLoading="0" deferRender="true" reloadSelector="#mrListReload" cssClass="table table-striped" dom="ltipr" id="reading" url="${spring:mvcUrl('datatables-api#readings').build()}" serverSide="true" filterPlaceholder="none" filterSelector="#filterButton" filterClearSelector="#filterClearButton">
                            <datatables:column property="id" filterable="true" visible="false" sortInitDirection="desc" sortInitOrder="0"/>
                            <datatables:column title="Acct No." name="account-number" property="account.number" filterable="true" sortable="false" renderFunction="custom-rendering#accountUrl"/>
                            <datatables:column name="lastname" property="account.customer.lastname" sortable="false" visible="false"/>
                            <datatables:column name="firstname"  property="account.customer.firstName" sortable="false" visible="false"/>
                            <datatables:column name="month" property="schedule.month" visible="false"/>
                            <datatables:column name="year" property="schedule.year" visible="false" />
                            <datatables:column name="barangay" property="account.address.brgy" visible="false" sortable="false"/>
                            <datatables:column name="purok" property="account.purok" visible="false" sortable="false"/>
                            <datatables:column name="status" property="invoice.status" sortable="false" visible="false"/>
                            <datatables:column title="Name" sortable="false" property="account.customer.name" renderFunction="custom-rendering#customerUrlReadingList"/>
                            <datatables:column title="Schedule" sortable="false" renderFunction="custom-rendering#scheduleAndStatus"/>
                            <datatables:column title="Previous" property="previous" sortable="false"/>
                            <datatables:column title="Present" name="reading" property="readingValue" cssCellClass="reading" sortable="false"/>
                            <datatables:column title="Consumption" name="consume" property="consumption" cssCellClass="consumption"/>
                            <datatables:column title="Actions" sortable="false" renderFunction="custom-rendering#readingListActions"/>
                            <datatables:extraJs bundles="mreading" placeholder="before_end_document_ready"/>
                            <datatables:extraJs bundles="session-timeout" placeholder="before_end_document_ready"/>
                            <dandelion:bundle excludes="jquery"/>
                        </datatables:table>
                        <input type="hidden" id="row-num">
                        <input type="hidden" id="bills-uri" value="${pageContext.servletContext.contextPath}/admin/bills/">
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../fragments/modals/reading-info.jsp"/>
        <jsp:include page="../fragments/modals/no-reading-info.jsp"/>
        <script src="${WEB_JARS}jquery/2.0.3/jquery.min.js"></script>
        <script src="${STATIC_URL}js/bootstrap.min.js"></script>
        <script src="${STATIC_URL}js/bootstrap-toggle.min.js"></script>
        <script src="${STATIC_URL}js/bootstrap-dialog.min.js"></script>
        <script src="${STATIC_URL}js/helpers/form-validation.js"></script>
        <script src="${STATIC_URL}js/global.js"></script>
        <script src="${STATIC_URL}js/helpers/reports-helper.js"></script>
        <script src="${STATIC_URL}js/meter-reading/list.js"></script>
        <script>
            $(document).ready(function(){
                $('#content-loader').hide()
                $('#main-content').show();
            });
        </script>
    </body>
</html>