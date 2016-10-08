<%@ include file="../postAuth/taglibs.jsp"%>
<div class="modal fade" id="bill-discount-form-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Update Discount</h4>
            </div>
            <div class="modal-body">
                <fieldset>
                    <div class="col-sm-12">
                        <h4 class="sub-header">Account Details</h4>
                        <div class="col-sm-6 info-wrapper">
                            <img class="info-img" src="${STATIC_URL}img/un.png">
                            <div class="info-text">
                                <span id="bill-dc-full-name"></span>
                            </div>
                        </div>
                        <div class="col-sm-6 info-wrapper">
                            <img class="info-img" src="${STATIC_URL}img/address.PNG">
                            <div class="info-text">
                                <span id="bill-dc-address"></span>
                            </div>
                        </div>
                        <div class="col-sm-6 info-wrapper">
                            <img class="info-img" src="${STATIC_URL}img/standing_balance.png">
                            <div class="info-text">
                                <span id="bill-dc-due"></span>
                            </div>
                        </div>
                        <div class="col-sm-6 info-wrapper">
                            <img class="info-img" src="${STATIC_URL}img/date.png">
                            <div class="info-text">
                                <span id="bill-dc-date"></span>
                            </div>
                        </div>
                        <h4 class="sub-header">Discount Form</h4>
                        <form:form id="discount-form" action="#" modelAttribute="billDiscountForm" role="form">
                            <jsp:include page="../postAuth/form-alerts.jsp"/>
                            <form:hidden id="dc-id" path="id"/>
                            <cws:input id="dc-val" name="discount" label="Discount" icon="money" placeholder="Enter discount" required="true" size="4"/>
                            <div class="col-sm-4 submit-container">
                                <button type="submit" class="btn btn-primary submit-left">Submit</button>
                            </div>
                        </form:form>
                    </div>
                </fieldset>
            </div>
        </div>
    </div>
</div>
