package dev.carbajal.repositories;

import java.util.List;

import dev.carbajal.models.Editor;

public interface EditorDAO {
	
	// CRUD //
	
	// Create
	
	public Editor addEditor(Editor ed);
	
	// Read
	
	public List<Editor> getAllEditorsByCommittee(String committee);
	
	public List<Editor> getEditorsByLogin(String username, String password);
	
	public Editor getEditor(String username, String committee);
	
	public Editor getEditorById(int editorId);
	
//	public boolean checkIfEditorExists(int editorId);
	
	// Update
	
	public void updateEditor(Editor ed);
	
	// Delete
	
	public void deleteEditor(Editor ed);

}
