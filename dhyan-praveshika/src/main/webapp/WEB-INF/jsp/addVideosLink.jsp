 <script>
if ( window.history.replaceState ) {
  window.history.replaceState( null, null, '/dhyanpraveshika-web/videos' );
}
</script> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="editAddVideoModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
      
        <form action="/dhyanpraveshika-web/addVideo" method = "post">
        <input type="hidden" id="id" name="id">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add/Edit Video</h4>
          </div>
          <div class="modal-body">

            <div class="form-group">
              <label>Video Title</label>
              <input type="text" id="title" name="title" class="form-control" required="required">
            </div>

            <div class="form-group">
              <label>Video Category</label>
              <select class="form-control" id="category" name="category">
                <option>Genaral</option>
                <option>Meditation</option>
              </select>
            </div>


            <div class="form-group">
              <label>Video Embaded URL</label>
              <input type="text" id="path" class="form-control" name="path" required="required">
            </div>

          </div>

          <div class="modal-footer">
            <input type="submit" class="btn btn-primary" value = "Save"/>
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </div>
        </form>
      </div>
    </div>
  </div>
