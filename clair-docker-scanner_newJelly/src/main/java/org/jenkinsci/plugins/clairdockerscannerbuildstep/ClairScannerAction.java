package org.jenkinsci.plugins.clairdockerscannerbuildstep;

import hudson.model.Action;
import hudson.model.AbstractBuild;

public class ClairScannerAction implements Action {

	private String resultsUrl;
	private AbstractBuild<?, ?> build;

	// private String artifactSuffix;
	private String localImage;

	public ClairScannerAction(AbstractBuild<?, ?> build, String artifactName,
			String localImage) {

		this.build = build;
		// this.artifactSuffix = artifactSuffix;
		this.resultsUrl = "../artifact/" + artifactName;
		this.localImage = localImage;
	}

	@Override
	public String getIconFileName() {
		// return the path to the icon file
		return "/plugin/clair-docker-scanner/images/clair.png";
	}

	@Override
	public String getDisplayName() {
		// return the label for your link

		return "Clair Docker Scanner " + localImage;
	}

	@Override
	public String getUrlName() {
		// defines the suburl, which is appended to
		// ...jenkins/job/jobname/<build_number>/

		return localImage;
	}

	public AbstractBuild<?, ?> getBuild() {
		return this.build;
	}

	public String getResultsUrl() {
		return this.resultsUrl;
	}
}
