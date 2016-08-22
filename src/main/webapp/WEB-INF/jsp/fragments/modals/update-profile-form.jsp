<%@ include file="../postAuth/taglibs.jsp"%>
<div class="modal fade" id="update-profile-form-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title">Update Profile</h3>
            </div>
            <div class="modal-body">
                <fieldset>
                    <form:form action="${pageContext.servletContext.contextPath}/admin/update-name" id="md-name-edit-form">
                        <div class="col-sm-12 alert alert-success success-msg">
                            <a href="#" class="close" data-hide="alert" aria-label="close">&times;</a>
                        </div>
                        <div class="col-sm-12 form-group">
                            <div class="col-sm-4 has-feedback ">
                                <label class="control-label" for="fn">Fullname</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                    <input id="fn" type="text" name="fullName" value="<sec:authentication property="principal.fullName"/>" placeholder="Enter fullname" autocomplete="off" class="form-control" required="true">
                                </div>
                            </div>
                            <div class="col-sm-4 submit-container">
                                <button type="submit" class="btn btn-primary submit-left">Submit</button>
                            </div>
                        </div>
                    </form:form>
                    <form:form id="md-password-edit" action="${pageContext.servletContext.contextPath}/admin/update-password">
                        <div class="col-sm-12 form-group">
                            <div class="col-sm-4 has-feedback ">
                                <label class="control-label">Current Password</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span>
                                    <input id="current-pw" type="password" name="current" placeholder="Enter current password" class="form-control" required="true">
                                </div>
                            </div>
                            <div class="col-sm-4 has-feedback ">
                                <label class="control-label">New Password</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span>
                                    <input id="new-pw" type="password" name="new" placeholder="Enter new password" class="form-control" required="true">
                                </div>
                            </div>
                            <div id="rt-profile-container" class="col-sm-4 has-feedback ">
                                <label class="control-label" for="rt-new-pw">Retype New Password</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span>
                                    <input id="rt-new-pw" name="retype" placeholder="Retype new password" class="form-control" required="true" type="password">
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 form-group">
                            <div class="col-sm-4 pull-align-right">
                                <button type="submit" id="update-submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </form:form>
                </fieldset>
            </div>
        </div>
    </div>
</div>