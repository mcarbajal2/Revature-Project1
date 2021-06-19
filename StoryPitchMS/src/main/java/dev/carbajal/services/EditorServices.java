package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Editor;

public interface EditorServices {
	
	public Editor addEditor(Editor ed);
	
	public List<Editor> getAllEditorsByCommittee(String committee);
	
	public List<Editor> getEditorsByLogin(String username, String password);
	
	public Editor getEditor(String username, String committee);
	
	public Editor getEditorById(int editorId);
	
	public void updateEditor(Editor ed);
	
	public void deleteEditor(Editor ed);

}
