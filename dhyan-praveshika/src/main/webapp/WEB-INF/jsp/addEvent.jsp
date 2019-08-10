<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!--Modal edit View Article-->
  <div class="modal fade" id="editAddEventModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <form action="/addEvent"  method="post" enctype="multipart/form-data">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add/Edit Event</h4>
          </div>
          <div class="modal-body">

            <div class="form-group">
              <label>Event Title</label>
              <input type="text" rows="4" name="title" class="form-control">
            </div>

            <div class="form-group">
              <label>Event Image</label>
              <div class="input-group">
                <input id="hiddenFileOpner" class="hidden" type="file" name="file" class="form-control"
                  placeholder="Select Image...">
                <input id="imageNameShowBox" type="text" class="form-control" placeholder="Select Image..." readonly>
                <span class="input-group-btn" id="eventSelectImage">
                  <button class="btn btn-default" type="button">Browse</button>
                </span>
              </div><!-- /input-group -->
            </div>

            <div class="form-group">
              <label>Description</label>
              <textarea type="text" rows="3" name="description" class="form-control"></textarea>
            </div>

            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label>Event Date</label>
                  <input type="date" name="date" class="form-control">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label>Event Time</label>
                  <input type="time" name="time" class="form-control">
                </div>
              </div>
            </div>

            <div class="form-group">
              <label>Location</label>
              <input type="text" name="location" class="form-control">
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