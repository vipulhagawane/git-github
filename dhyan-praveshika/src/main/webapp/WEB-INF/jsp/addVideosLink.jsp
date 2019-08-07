<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<div class="modal fade" id="editAddVideoModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
      
        <form action="/addVideosLink">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add/Edit Video</h4>
          </div>
          <div class="modal-body">

            <div class="form-group">
              <label>Video Title</label>
              <input type="text" class="form-control">
            </div>

            <div class="form-group">
              <label>Video Category</label>
              <select class="form-control" id="sel1">
                <option>Genaral</option>
                <option>Meditation</option>
              </select>
            </div>


            <div class="form-group">
              <label>Video Embaded URL</label>
              <input type="text" class="form-control">
            </div>

          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </div>
        </form>
      </div>
    </div>
  </div>


<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html> -->